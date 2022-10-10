filein="employeedata.csv"
IFS=$'\n'

if [ ! -f "$filein" ]
then
  echo "Cannot find file $filein"
else

  #create arrays of groups, full names, and usernames
  groups=(`cut -d: -f 6 "$filein" | sed 's/ //'`)
  fullnames=(`cut -d: -f 1 "$filein"`)
  userid=(`cut -d: -f 2 "$filein"`)
  usernames=(`cut -d: -f 1 "$filein" | tr [A-Z] [a-z] | awk '{print substr($1,1,1) $2}'`)

  #checks if the group exists, if not then creates it
  for group in ${groups[*]}
  do
    grep -q "^$group" /etc/group ; let x=$?
    if [ $x -eq 1 ]
    then
      groupadd "$group"
    fi
  done

  #creates the user accounts, adds them to groups, and sets passwords
  #then once account is created, mails the account
  x=0
  created=0
  for user in ${usernames[*]}
  do
    useradd -n -c ${fullnames[$x]} -g "${groups[$x]}" $user 2> /dev/null
    if [ $? -eq 0 ]
    then
      let created=$created+1
    fi
  #  echo "Name: ${fullnames[$x]}, un: $user, pw: ${userid[$x]}"
    #This creates the password for the user suppresses output of passwd
    #The -p in the useradd function doesn't set it properly
    echo "${userid[$x]}" | passwd --stdin "$user" > /dev/null

    #sends mail to user
    echo "Welcome! Your account has been created.  Your username is $user and temporary password is \"$password\" without the quotes." | mail -s "New Account for $user" -b root $user
    x=$x+1
    echo -n "..."
    sleep .25
  done
  sleep .25
  echo " " 
  echo "Complete. $created accounts have been created."
fi