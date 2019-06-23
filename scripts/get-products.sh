#!/usr/bin/env bash
TOKEN=$1
curl -H "Authorization: ${TOKEN}" localhost:8080/products