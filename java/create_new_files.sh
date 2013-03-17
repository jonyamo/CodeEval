#!/bin/sh

BASEDIR=src/com/codeeval
CHALLENGEDIR=$BASEDIR/challenges
CLASSDIR=$CHALLENGEDIR/$1
TESTDATADIR=../testdata

mkdir -p $CLASSDIR
sed "s/skeleton/$1/g" skeleton.java > $CLASSDIR/Main.java

touch $TESTDATADIR/$1.txt
