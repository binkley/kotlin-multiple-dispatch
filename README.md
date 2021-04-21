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

### Why not other approaches?

Consider this scratch snippet:

```kotlin
fun Device<*>.xxx(command: Command<*>): Int =
  throw MissingMethodException(this, command)
fun M1ADevice.xxx(command: ResetCommand) = 3

fun main() {
  // ResetCommand is an singleton object; other values are defined elsewhere
  m1aDevice.xxx(ResetCommand) // Calls the first `xxx` fun, above
  m1aDevice.xxx(timeCommand) // Also calls the first `xxx` fun
}
```

The compiler correctly warns that `M1ADevice.xxx(TimeCommand)` is never
called: Extension functions do not consider type specialization.

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
