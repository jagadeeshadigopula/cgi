varl=$((RANDOM % 9))


while :

do

echo "Enter a number"

read var2

if (( var2 == varl ))

then

echo "You guess right"

break

fi


if ((var2 > varl ))

then

echo "guss low number:"

fi

if (( var2 < varl ))

then

echo "guess high number"

fi

done