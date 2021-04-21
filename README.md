<a href="./LICENSE.md">
<img src="./images/public-domain.png" alt="Public Domain"
align="right"/>
</a>

# Kotlin Multiple Dispatch

This code is a "finger exercise"&mdash;written for pleasure&mdash;of examples
for simulating multiple dispatch in Kotlin.

## Build and try

To build, use `./mvnw clean verify`.

Try `./run` for a demonstration.

There are no run-time dependencies beyond the Kotlin standard library.

To build as CI would, use `./batect build`.

Try `./batect run` for a demonstration as CI would.

---

## TOC

* [Build and try](#build-and-try)
* [Multiple dispatch](#multiple-dispatch)
* [Examples](#examples)
* [Reading](#reading)

---

## Multiple dispatch

---

## Examples

Multiple dispatch for this matrix of combinations:

| | Reset | Name (M1) | Name (M2)
| - | :-: | :-: | :-:
| **Dummy** | _A_ | - | -
| **M1A** | _A_ | _B_ | -
| **M1B** | _A_ | _C_ | -
| **M2** | _A_ | _D_ | _E_

Each capital letter represents a separate unique or shared implementation.

---

## Reading

* [_A polyglot's guide to multiple
  dispatch_](https://eli.thegreenplace.net/2016/a-polyglots-guide-to-multiple-dispatch/)
  ([part 2](https://eli.thegreenplace.net/2016/a-polyglots-guide-to-multiple-dispatch-part-2/),
  [part 3](https://eli.thegreenplace.net/2016/a-polyglots-guide-to-multiple-dispatch-part-3/),
  [part 4](https://eli.thegreenplace.net/2016/a-polyglots-guide-to-multiple-dispatch-part-4/))
* [_An Introduction to Invoke Dynamic in the
  JVM_](https://www.baeldung.com/java-invoke-dynamic) (Java 7+)
* [_Multimethods and
  Hierarchies_](https://clojure.org/reference/multimethods) (Clojure)
* [_Multiple dispatch_](https://en.wikipedia.org/wiki/Multiple_dispatch)
  (overview)
