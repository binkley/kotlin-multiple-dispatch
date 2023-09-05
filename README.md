<a href="./LICENSE.md">
<img src="./images/public-domain.svg" alt="Public Domain"
align="right" width="20%" height="auto"/>
</a>

# Kotlin Multiple Dispatch

[![build](https://github.com/binkley/kotlin-multiple-dispatch/workflows/build/badge.svg)](https://github.com/binkley/kotlin-multiple-dispatch/actions)
[![issues](https://img.shields.io/github/issues/binkley/kotlin-multiple-dispatch.svg)](https://github.com/binkley/kotlin-multiple-dispatch/issues/)
[![vulnerabilities](https://snyk.io/test/github/binkley/kotlin-multiple-dispatch/badge.svg)](https://snyk.io/test/github/binkley/kotlin-multiple-dispatch)
[![license](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

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

| | Reset | Time | Name (M1) | Name (M2)
| - | :-: | :-: | :-: | :-:
| **M1A** | _A_ | _B_ | _C_ | -
| **M1B** | _A_ | _B_ | _D_ | -
| **M2** | _A_ | _E_ | _F_ | _G_

Each capital letter represents a separate unique or shared implementation
(lambda).

See [`main`](./src/main/kotlin/hm/binkley/labs/main.kt) for a starting
point.  [`register(lambda)`](./src/main/kotlin/hm/binkley/labs/implement-with-map.kt)
updates the dispatch table;
[`dispatch(device, component)`](./src/main/kotlin/hm/binkley/labs/implement-with-map.kt)
looks up and dispatches the corresponding lambda;
[`registerAll()`](src/main/kotlin/hm/binkley/labs/main.kt)
sets up the multimethod mappings.

### Why not other approaches?

Consider this scratch snippet:

```kotlin
fun Device<*>.alternativeDispatch(command: Command<*>): Int =
    throw MissingMethodException(this, command)
fun M1ADevice.alternativeDispatch(command: ResetCommand) = 3

fun main() {
    // ResetCommand is an singleton object; other values are defined elsewhere
    m1aDevice.alternativeDispatch(ResetCommand) // Calls the first `xxx` fun, above
    m1aDevice.alternativeDispatch(timeCommand) // Also calls the first `xxx` fun
}
```

The compiler correctly warns that `M1ADevice.alternativeDispatch(TimeCommand)`
is never called: Extension functions do not consider type specialization.

---

## Reading

* [_A polyglot's guide to multiple
  dispatch_](https://eli.thegreenplace.net/2016/a-polyglots-guide-to-multiple-dispatch/)
  ([part 2](https://eli.thegreenplace.net/2016/a-polyglots-guide-to-multiple-dispatch-part-2/),
  [part 3](https://eli.thegreenplace.net/2016/a-polyglots-guide-to-multiple-dispatch-part-3/),
  [part 4](https://eli.thegreenplace.net/2016/a-polyglots-guide-to-multiple-dispatch-part-4/))
* [_An Introduction to Invoke Dynamic in the
  JVM_](https://www.baeldung.com/java-invoke-dynamic) (Java 7+)
* [_Multi Methods_](http://wiki.c2.com/?MultiMethods) (C2 wiki discussion)
* [_Multimethods and
  Hierarchies_](https://clojure.org/reference/multimethods) (Clojure)
* [_Multiple dispatch_](https://en.wikipedia.org/wiki/Multiple_dispatch)
  (overview)
