#!/bin/bash

curl -X PUT "http://localhost:8081/submodels/aHR0cHM6Ly9hZG1pbi1zaGVsbC5pby9pZHRhL1RpbWVTZXJpZXMvMS8xXzI=/submodel-elements/Segments/attachment" \
-H "Accept: application/json" \
-H "Content-Type: multipart/form-data" \
-F "fileName=basyx_thumbnail.png" \
-F "file=@basyx_thumbnail.png"