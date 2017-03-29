#!/bin/bash
echo "Running" $1
gradle -q run < input/$1.in > output/$1.out

