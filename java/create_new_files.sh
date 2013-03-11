#!/bin/sh

BASEDIR=src/com/codeeval
CHALLENGEDIR=$BASEDIR/challenges
TESTSDIR=$BASEDIR/tests

sed "s/skeleton/$1/g" $CHALLENGEDIR/skeleton.java > $CHALLENGEDIR/$1.java
sed "s/skeleton/$1/g;s/\/\/System/System/" $TESTSDIR/skeletonTest.java > $TESTSDIR/$1Test.java

