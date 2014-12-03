charset
=======

Clojure wrappers around some of the class and instance methods of java.nio.charset.Charset.

## Installation

Add the following dependency to your `project.clj` file:

[![Clojars Project](http://clojars.org/charset/latest-version.svg)](http://clojars.org/charset)

## Usage

```clojure
user=> (require ['charset.core :refer ['ascii 'utf-8 'utf-16]] 
				['charset.bytes :refer ['get-bytes 'ascii-bytes 
										'utf8-bytes 'utf16-bytes]])
nil

user=> (def street "Maple St")
#'user/street

user=> (get-bytes street)
#<byte[] [B@4dda1665>

user=> (get-bytes street "ascii")
#<byte[] [B@ca01786>

user=> (get-bytes street ascii)
#<byte[] [B@43780824>

user=> (ascii-bytes street)
#<byte[] [B@2e264899>

user=> (String. (ascii-bytes street))
"Maple St"

user=> (String. (utf8-bytes street))
"Maple St"

user=> (String. (utf16-bytes street) "utf-16")
"Maple St"
```

## Documentation

[API](http://clavoie.github.io/charset/)

## License

Copyright © 2013-2014 Chris LaVoie

Distributed under the Eclipse Public License, the same as Clojure.
