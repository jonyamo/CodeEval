#!/bin/sh

BASEDIR=src/com/codeeval
CHALLENGEDIR=$BASEDIR/challenges
CLASSDIR=$CHALLENGEDIR/$1

mkdir -p $CLASSDIR
sed "s/skeleton/$1/g" skeleton.java > $CLASSDIR/Main.java

