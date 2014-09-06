#!/usr/bin/env bash
while read line; do
  compressed_seq=""
  last_digit=""
  count=0
  for digit in $line; do
    if [[ -z $last_digit || "$digit" == "$last_digit" ]]; then
      count=$[$count + 1]
    else
      compressed_seq+="$count $last_digit "
      count=1
    fi
    last_digit=$digit
  done
  echo "${compressed_seq}$count $last_digit"
done < "$1"
