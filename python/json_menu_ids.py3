#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json
import os

from sys import argv

def get_json_list_from_file(filename):
    if not os.path.exists(filename):
        raise Exception

    with open(filename) as f:
        json_list = list(filter(None, (line.rstrip() for line in f)))

    return json_list


def get_sum_of_items(json_dict):
    sum = 0
    if 'menu' in json_dict and 'items' in json_dict['menu']:
        for item in json_dict['menu']['items']:
            if item != None and 'id' in item and 'label' in item:
                sum = sum + item['id']
    return sum


def main():
    script, filename = argv
    json_list = get_json_list_from_file(filename)
    for json_str in json_list:
        try:
            json_dict = json.loads(json_str)
        except:
            json_dict = {}
        print(get_sum_of_items(json_dict))


if __name__ == '__main__':
    main()
