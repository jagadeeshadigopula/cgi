#!/bin/bash
filesystems=("/" "/c")
for i in ${filesystems[@]}; 
do
usage=$(df -h $i | tail -n 1 | awk '{print $5}' | cut -d % -f1)
if [[ "$usage" -le 90 ]]; 
then
alert="Running out of space on $i, Usage is: $usage%"
echo "Sending out a disk space alert email."
echo $alert | mail -v -s "$i is $usage% full" jagadeeshadigopula@gmail.com
fi
done
