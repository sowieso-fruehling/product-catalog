#!/usr/bin/env bash
curl -XPOST -H 'Content-Type: application/json' 'localhost:8080/authenticate' -d '{"username": "username","password":"password"}'