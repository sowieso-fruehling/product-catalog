#!/usr/bin/env bash

TOKEN_VALID_UNTIL_21190530="Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImV4cCI6NDcxNDkyNDAwOSwiaWF0IjoxNTYxMzI0MDA5fQ.U6arTWzxzu-Fl2AhLEloYBZ8wNdHPqUu1ffWjQp6vnSc36dOoRLLyggO7KdvNPGbnLxlKQbXbRzbCtMc5eleqA"

curl -X POST -H "Authorization: ${TOKEN_VALID_UNTIL_21190530}" -H "Content-Type: application/json" localhost:8080/catalog-api/v1/products -d \
'[{
            "title": "Title 0",
            "description": "Description 0",
            "brand": "Brand 0",
            "price": 123.34,
            "color": "Colour 0"
        },
        {
            "title": "Title 1",
            "description": "Description 1",
            "brand": "Brand 1",
            "price": 124.34,
            "color": "Colour 1"
        },
        {
            "title": "Title 2",
            "description": "Description 2",
            "brand": "Brand 2",
            "price": 125.34,
            "color": "Colour 2"
        },
        {
            "title": "Title 3",
            "description": "Description 3",
            "brand": "Brand 3",
            "price": 126.34,
            "color": "Colour 3"
        },
        {
            "title": "Title 4",
            "description": "Description 4",
            "brand": "Brand 4",
            "price": 127.34,
            "color": "Colour 4"
        },
        {
            "title": "Title 5",
            "description": "Description 5",
            "brand": "Brand 5",
            "price": 128.34,
            "color": "Colour 5"
        },
        {
            "title": "Title 6",
            "description": "Description 6",
            "brand": "Brand 6",
            "price": 129.34,
            "color": "Colour 6"
        },
        {
            "title": "Title 7",
            "description": "Description 7",
            "brand": "Brand 7",
            "price": 130.34,
            "color": "Colour 7"
        },
        {
            "title": "Title 8",
            "description": "Description 8",
            "brand": "Brand 8",
            "price": 131.34,
            "color": "Colour 8"
        },
        {
             "title": "Title 9",
            "description": "Description 9",
            "brand": "Brand 9",
            "price": 132.34,
            "color": "Colour 9"
        },
        {
             "title": "Title 10",
            "description": "Description 10",
            "brand": "Brand 10",
            "price": 133.34,
            "color": "Colour 10"
        },
        {
             "title": "Title 11",
            "description": "Description 11",
            "brand": "Brand 11",
            "price": 134.34,
            "color": "Colour 11"
        },
        {
             "title": "Title 12",
            "description": "Description 12",
            "brand": "Brand 12",
            "price": 135.34,
            "color": "Colour 12"
        },
        {
             "title": "Title 13",
            "description": "Description 13",
            "brand": "Brand 13",
            "price": 136.34,
            "color": "Colour 13"
        },
        {
             "title": "Title 14",
            "description": "Description 14",
            "brand": "Brand 14",
            "price": 137.34,
            "color": "Colour 14"
        },
        {
             "title": "Title 15",
            "description": "Description 15",
            "brand": "Brand 15",
            "price": 138.34,
            "color": "Colour 15"
        },
        {
             "title": "Title 16",
            "description": "Description 16",
            "brand": "Brand 16",
            "price": 139.34,
            "color": "Colour 16"
        },
        {
             "title": "Title 17",
            "description": "Description 17",
            "brand": "Brand 17",
            "price": 140.34,
            "color": "Colour 17"
        },
        {
             "title": "Title 18",
            "description": "Description 18",
            "brand": "Brand 18",
            "price": 141.34,
            "color": "Colour 18"
        },
        {
             "title": "Title 19",
            "description": "Description 19",
            "brand": "Brand 19",
            "price": 142.34,
            "color": "Colour 19"
        },
        {
             "title": "Title 20",
            "description": "Description 20",
            "brand": "Brand 20",
            "price": 143.34,
            "color": "Colour 20"
        },
        {
             "title": "Title 21",
            "description": "Description 21",
            "brand": "Brand 21",
            "price": 144.34,
            "color": "Colour 21"
        },
        {
             "title": "Title 22",
            "description": "Description 22",
            "brand": "Brand 22",
            "price": 145.34,
            "color": "Colour 22"
        },
        {
             "title": "Title 23",
            "description": "Description 23",
            "brand": "Brand 23",
            "price": 146.34,
            "color": "Colour 23"
        },
        {
             "title": "Title 24",
            "description": "Description 24",
            "brand": "Brand 24",
            "price": 147.34,
            "color": "Colour 24"
        },
        {
             "title": "Title 25",
            "description": "Description 25",
            "brand": "Brand 25",
            "price": 148.34,
            "color": "Colour 25"
        },
        {
             "title": "Title 26",
            "description": "Description 26",
            "brand": "Brand 26",
            "price": 149.34,
            "color": "Colour 26"
        },
        {
             "title": "Title 27",
            "description": "Description 27",
            "brand": "Brand 27",
            "price": 150.34,
            "color": "Colour 27"
        },
        {
             "title": "Title 28",
            "description": "Description 28",
            "brand": "Brand 28",
            "price": 151.34,
            "color": "Colour 28"
        },
        {
             "title": "Title 29",
            "description": "Description 29",
            "brand": "Brand 29",
            "price": 152.34,
            "color": "Colour 29"
        },
        {
             "title": "Title 30",
            "description": "Description 30",
            "brand": "Brand 30",
            "price": 153.34,
            "color": "Colour 30"
        },
        {
             "title": "Title 31",
            "description": "Description 31",
            "brand": "Brand 31",
            "price": 154.34,
            "color": "Colour 31"
        },
        {
             "title": "Title 32",
            "description": "Description 32",
            "brand": "Brand 32",
            "price": 155.34,
            "color": "Colour 32"
        },
        {
             "title": "Title 33",
            "description": "Description 33",
            "brand": "Brand 33",
            "price": 156.34,
            "color": "Colour 33"
        },
        {
             "title": "Title 34",
            "description": "Description 34",
            "brand": "Brand 34",
            "price": 157.34,
            "color": "Colour 34"
        },
        {
             "title": "Title 35",
            "description": "Description 35",
            "brand": "Brand 35",
            "price": 158.34,
            "color": "Colour 35"
        },
        {
             "title": "Title 36",
            "description": "Description 36",
            "brand": "Brand 36",
            "price": 159.34,
            "color": "Colour 36"
        },
        {
             "title": "Title 37",
            "description": "Description 37",
            "brand": "Brand 37",
            "price": 160.34,
            "color": "Colour 37"
        },
        {
             "title": "Title 38",
            "description": "Description 38",
            "brand": "Brand 38",
            "price": 161.34,
            "color": "Colour 38"
        },
        {
             "title": "Title 39",
            "description": "Description 39",
            "brand": "Brand 39",
            "price": 162.34,
            "color": "Colour 39"
        },
        {
             "title": "Title 40",
            "description": "Description 40",
            "brand": "Brand 40",
            "price": 163.34,
            "color": "Colour 40"
        },
        {
             "title": "Title 41",
            "description": "Description 41",
            "brand": "Brand 41",
            "price": 164.34,
            "color": "Colour 41"
        },
        {
             "title": "Title 42",
            "description": "Description 42",
            "brand": "Brand 42",
            "price": 165.34,
            "color": "Colour 42"
        },
        {
             "title": "Title 43",
            "description": "Description 43",
            "brand": "Brand 43",
            "price": 166.34,
            "color": "Colour 43"
        },
        {
             "title": "Title 44",
            "description": "Description 44",
            "brand": "Brand 44",
            "price": 167.34,
            "color": "Colour 44"
        },
        {
             "title": "Title 45",
            "description": "Description 45",
            "brand": "Brand 45",
            "price": 168.34,
            "color": "Colour 45"
        },
        {
             "title": "Title 46",
            "description": "Description 46",
            "brand": "Brand 46",
            "price": 169.34,
            "color": "Colour 46"
        },
        {
             "title": "Title 47",
            "description": "Description 47",
            "brand": "Brand 47",
            "price": 170.34,
            "color": "Colour 47"
        },
        {
             "title": "Title 48",
            "description": "Description 48",
            "brand": "Brand 48",
            "price": 171.34,
            "color": "Colour 48"
        },
        {
             "title": "Title 49",
            "description": "Description 49",
            "brand": "Brand 49",
            "price": 172.34,
            "color": "Colour 49"
        },
        {
             "title": "Title 50",
            "description": "Description 50",
            "brand": "Brand 50",
            "price": 173.34,
            "color": "Colour 50"
        },
        {
             "title": "Title 51",
            "description": "Description 51",
            "brand": "Brand 51",
            "price": 174.34,
            "color": "Colour 51"
        },
        {
             "title": "Title 52",
            "description": "Description 52",
            "brand": "Brand 52",
            "price": 175.34,
            "color": "Colour 52"
        },
        {
             "title": "Title 53",
            "description": "Description 53",
            "brand": "Brand 53",
            "price": 176.34,
            "color": "Colour 53"
        },
        {
             "title": "Title 54",
            "description": "Description 54",
            "brand": "Brand 54",
            "price": 177.34,
            "color": "Colour 54"
        },
        {
             "title": "Title 55",
            "description": "Description 55",
            "brand": "Brand 55",
            "price": 178.34,
            "color": "Colour 55"
        },
        {
             "title": "Title 56",
            "description": "Description 56",
            "brand": "Brand 56",
            "price": 179.34,
            "color": "Colour 56"
        },
        {
             "title": "Title 57",
            "description": "Description 57",
            "brand": "Brand 57",
            "price": 180.34,
            "color": "Colour 57"
        },
        {
             "title": "Title 58",
            "description": "Description 58",
            "brand": "Brand 58",
            "price": 181.34,
            "color": "Colour 58"
        },
        {
             "title": "Title 59",
            "description": "Description 59",
            "brand": "Brand 59",
            "price": 182.34,
            "color": "Colour 59"
        },
        {
             "title": "Title 60",
            "description": "Description 60",
            "brand": "Brand 60",
            "price": 183.34,
            "color": "Colour 60"
        },
        {
             "title": "Title 61",
            "description": "Description 61",
            "brand": "Brand 61",
            "price": 184.34,
            "color": "Colour 61"
        },
        {
             "title": "Title 62",
            "description": "Description 62",
            "brand": "Brand 62",
            "price": 185.34,
            "color": "Colour 62"
        },
        {
             "title": "Title 63",
            "description": "Description 63",
            "brand": "Brand 63",
            "price": 186.34,
            "color": "Colour 63"
        },
        {
             "title": "Title 64",
            "description": "Description 64",
            "brand": "Brand 64",
            "price": 187.34,
            "color": "Colour 64"
        },
        {
             "title": "Title 65",
            "description": "Description 65",
            "brand": "Brand 65",
            "price": 188.34,
            "color": "Colour 65"
        },
        {
             "title": "Title 66",
            "description": "Description 66",
            "brand": "Brand 66",
            "price": 189.34,
            "color": "Colour 66"
        },
        {
             "title": "Title 67",
            "description": "Description 67",
            "brand": "Brand 67",
            "price": 190.34,
            "color": "Colour 67"
        },
        {
             "title": "Title 68",
            "description": "Description 68",
            "brand": "Brand 68",
            "price": 191.34,
            "color": "Colour 68"
        },
        {
             "title": "Title 69",
            "description": "Description 69",
            "brand": "Brand 69",
            "price": 192.34,
            "color": "Colour 69"
        },
        {
             "title": "Title 70",
            "description": "Description 70",
            "brand": "Brand 70",
            "price": 193.34,
            "color": "Colour 70"
        },
        {
             "title": "Title 71",
            "description": "Description 71",
            "brand": "Brand 71",
            "price": 194.34,
            "color": "Colour 71"
        },
        {
             "title": "Title 72",
            "description": "Description 72",
            "brand": "Brand 72",
            "price": 195.34,
            "color": "Colour 72"
        },
        {
             "title": "Title 73",
            "description": "Description 73",
            "brand": "Brand 73",
            "price": 196.34,
            "color": "Colour 73"
        },
        {
             "title": "Title 74",
            "description": "Description 74",
            "brand": "Brand 74",
            "price": 197.34,
            "color": "Colour 74"
        },
        {
             "title": "Title 75",
            "description": "Description 75",
            "brand": "Brand 75",
            "price": 198.34,
            "color": "Colour 75"
        },
        {
             "title": "Title 76",
            "description": "Description 76",
            "brand": "Brand 76",
            "price": 199.34,
            "color": "Colour 76"
        },
        {
             "title": "Title 77",
            "description": "Description 77",
            "brand": "Brand 77",
            "price": 200.34,
            "color": "Colour 77"
        },
        {
             "title": "Title 78",
            "description": "Description 78",
            "brand": "Brand 78",
            "price": 201.34,
            "color": "Colour 78"
        },
        {
             "title": "Title 79",
            "description": "Description 79",
            "brand": "Brand 79",
            "price": 202.34,
            "color": "Colour 79"
        },
        {
             "title": "Title 80",
            "description": "Description 80",
            "brand": "Brand 80",
            "price": 203.34,
            "color": "Colour 80"
        },
        {
             "title": "Title 81",
            "description": "Description 81",
            "brand": "Brand 81",
            "price": 204.34,
            "color": "Colour 81"
        },
        {
             "title": "Title 82",
            "description": "Description 82",
            "brand": "Brand 82",
            "price": 205.34,
            "color": "Colour 82"
        },
        {
             "title": "Title 83",
            "description": "Description 83",
            "brand": "Brand 83",
            "price": 206.34,
            "color": "Colour 83"
        },
        {
             "title": "Title 84",
            "description": "Description 84",
            "brand": "Brand 84",
            "price": 207.34,
            "color": "Colour 84"
        },
        {
             "title": "Title 85",
            "description": "Description 85",
            "brand": "Brand 85",
            "price": 208.34,
            "color": "Colour 85"
        },
        {
             "title": "Title 86",
            "description": "Description 86",
            "brand": "Brand 86",
            "price": 209.34,
            "color": "Colour 86"
        },
        {
             "title": "Title 87",
            "description": "Description 87",
            "brand": "Brand 87",
            "price": 210.34,
            "color": "Colour 87"
        },
        {
             "title": "Title 88",
            "description": "Description 88",
            "brand": "Brand 88",
            "price": 211.34,
            "color": "Colour 88"
        },
        {
             "title": "Title 89",
            "description": "Description 89",
            "brand": "Brand 89",
            "price": 212.34,
            "color": "Colour 89"
        },
        {
             "title": "Title 90",
            "description": "Description 90",
            "brand": "Brand 90",
            "price": 213.34,
            "color": "Colour 90"
        },
        {
             "title": "Title 91",
            "description": "Description 91",
            "brand": "Brand 91",
            "price": 214.34,
            "color": "Colour 91"
        },
        {
             "title": "Title 92",
            "description": "Description 92",
            "brand": "Brand 92",
            "price": 215.34,
            "color": "Colour 92"
        },
        {
             "title": "Title 93",
            "description": "Description 93",
            "brand": "Brand 93",
            "price": 216.34,
            "color": "Colour 93"
        },
        {
             "title": "Title 94",
            "description": "Description 94",
            "brand": "Brand 94",
            "price": 217.34,
            "color": "Colour 94"
        },
        {
             "title": "Title 95",
            "description": "Description 95",
            "brand": "Brand 95",
            "price": 218.34,
            "color": "Colour 95"
        },
        {
             "title": "Title 96",
            "description": "Description 96",
            "brand": "Brand 96",
            "price": 219.34,
            "color": "Colour 96"
        },
        {
            "title": "Title 97",
            "description": "Description 97",
            "brand": "Brand 97",
            "price": 220.34,
            "color": "Colour 97"
        },
        {
            "title": "Title 98",
            "description": "Description 98",
            "brand": "Brand 98",
            "price": 221.34,
            "color": "Colour 98"
        },
        {
            "title": "Title 99",
            "description": "Description 99",
            "brand": "Brand 99",
            "price": 222.34,
            "color": "Colour 99"
        }]'