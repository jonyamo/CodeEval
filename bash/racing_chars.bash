#!/usr/bin/env bash
old_pos=-1
while read line; do
  new_pos=$(expr index "$line" C);
  if [[ $new_pos -gt 0 ]]; then
    replace=C
  else
    new_pos=$(expr index "$line" _);
    replace=_
  fi
  if [[ $old_pos -eq -1 || $new_pos -eq $old_pos ]]; then
    direction='|'
  elif [[ $new_pos -lt $old_pos ]]; then
    direction='/'
  else
    direction='\'
  fi
  old_pos=$new_pos
  echo "${line/$replace/$direction}"
done < "$1"
