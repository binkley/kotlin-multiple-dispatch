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

## Examples

This project demonstrates multiple dispatch for a matrix of combinations.
Devices run down the left; commands are across the top:

| | Reset | Name (M1) | Name (M2)
| - | :-: | :-: | :-:
| **Dummy** | _A_ | - | -
| **M1A** | _A_ | _B_ | -
| **M1B** | _A_ | _C_ | -
| **M2** | _A_ | _D_ | _E_

Each capital letter represents a separate unique or shared implementation 
(lambda).

See [`main`](./src/main/kotlin/hm/binkley/labs/Main.kt) for a starting
point.  [`register(lambda)`](./src/main/kotlin/hm/binkley/labs/multiple-dispatch-via-map.kt)
updates the dispatch table;
[`dispatch(device, component)`](./src/main/kotlin/hm/binkley/labs/multiple-dispatch-via-map.kt)
looks up and dispatches the corresponding lambda.

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
