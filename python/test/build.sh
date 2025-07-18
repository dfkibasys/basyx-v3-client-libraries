#!/bin/bash

cd ..

mvn install

cd ./build/generated/project

pip install -e .[dev]
cd ../../../test
python main.py
