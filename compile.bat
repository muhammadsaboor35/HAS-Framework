echo off
cls
dir /S /B *.java > .build
javac -Xlint -d ./bin @.build
pause