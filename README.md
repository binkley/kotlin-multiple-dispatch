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
