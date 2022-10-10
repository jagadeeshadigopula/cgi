#Mark Earleywine 08-29-2012
#This Powershell Script Finds the age and expiry date of passwords
#within an Active Directory domain.
#I modified this from the original script found here:
#http://www.scriptlogic.com/smbit/article/track-user-password-expiration-using-active-directory

Import-Module ActiveDirectory

#get current domain password policy
$policy=Get-ADDefaultDomainPasswordPolicy
#save the password age in days
$days=$Policy.MaxPasswordAge.TotalDays

do{
#prompt for username of account
$username = Read-Host "Enter username. (to exit type -1)"

#try and catch for error handling
    try {
        $user = Get-ADUser -Identity $username -Properties *
        if ($user.PasswordNeverExpires){
            $user | select Name,PasswordLastSet,
            @{Name="PasswordAge";Expression={(Get-Date) - $_.PasswordLastSet }},
            @{Name="PasswordExpiresOn";Expression={"Never"}}
        }
        else{
            $user | select Name,PasswordLastSet,
            @{Name="PasswordAge";Expression={(Get-Date) - $_.PasswordLastSet }},
            @{Name="PasswordExpiresOn";Expression={$_.PasswordLastSet + $days}}
            
        }
    }
    catch {
        write-host "Error bad username, try again."
    }  
}
while ($username -ne "-1")