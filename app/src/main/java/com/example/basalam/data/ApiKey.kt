package com.example.basalam.data

var QUERY =  "{productSearch(size: 20) {products {id name photo(size: LARGE) { url } vendor { name } weight price rating { rating count: signals } } } }"
var BASE_URL = "https://api.basalam.com/api/"