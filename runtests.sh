#!/bin/bash

for x in tests/*.in; do
    if [[ "$x" =~ "O-ok.in" ]]; then
        java -Din=$x -Dout=${x%.in}.outhyp rest.Outlet ;
    elif [ -e ${x%.in}.import ]; then
        java -DImport=${x%.in}.import -Din=$x -Dout=${x%.in}.outhyp rest.Manager ;
    else
        java -Din=$x -Dout=${x%.in}.outhyp rest.Manager ;
    fi

    diff -B -w ${x%.in}.out ${x%.in}.outhyp > ${x%.in}.diff ;
    if [ -s ${x%.in}.diff ]; then
        echo "FAIL: $x" ;
        cat ${x%.in}.diff ;
        exit 0 ;
    else
        # echo -n "."
        rm -f ${x%.in}.diff ${x%.in}.outhyp ; 
    fi
done

rm -f *.dat

echo "Done."

