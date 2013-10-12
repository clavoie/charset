(ns charset.core-test
  (:use clojure.test
        charset.core)
  (:import [java.nio.charset Charset CharsetDecoder CharsetEncoder]))

(defn- charset? [value] (instance? Charset value))

(deftest test-standard-charsets
  (is (charset? ascii))
  (is (charset? iso-latin-1))
  (is (charset? utf-8))
  (is (charset? utf-16-be))
  (is (charset? utf-16-le))
  (is (charset? utf-16))
  (is (charset? default-charset)))

(deftest test-all-charsets
  (let [all-charsets (all-charsets)]
    (is (map? all-charsets))
    (is (every? string? (keys all-charsets)))
    (is (every? charset? (vals all-charsets)))))

(deftest test-get-charset
  (is (charset? (get-charset "utf-8")))
  (is (thrown? Exception (get-charset "bogus-charset"))))

(deftest test-supported?
  (is (supported? "utf-8"))
  (is (not (supported? "bogus-charset"))))

(deftest test-aliases
  (let [aliases (aliases ascii)]
    (is (set? aliases))
    (is (every? string? aliases))))

(deftest test-charset-name
  (is (string? (charset-name ascii))))

(deftest test-decoder
  (is (instance? CharsetDecoder (decoder ascii))))

(deftest test-encode?
  (is (encode? ascii)))

(deftest test-encoder
  (is (instance? CharsetEncoder (encoder ascii))))

(deftest test-display-name
  (is (string? (display-name ascii))))

(deftest test-registered?
  (is (registered? ascii)))
