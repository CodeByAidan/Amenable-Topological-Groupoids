# Amenable Topological Groupoids in Java

##### Created by CodeByAidan 10/10/2023 :heart:

- [Amenable Topological Groupoids in Java](#amenable-topological-groupoids-in-java) - [Created by CodeByAidan](#created-by-codebyaidan-10102023-heart)
  - [Definition](#definition)
    - [Groupoid:](#groupoid)
      - [Partiality:](#partiality)
      - [Associativity:](#associativity)
    - [Topological Groupoid:](#topological-groupoid)
    - [Amenable Groupoid:](#amenable-groupoid)
  - [References](#references)
  - [Installation](#installation)

## Definition

### Groupoid:

A groupoid is a generalization of a group. It is a set $G$ equipped with a partial binary operation $(\cdot)$ that satisfies the following properties for all elements $a, b, c$ in $G$:

#### Partiality:

The operation $a \cdot b$ is defined if and only if there exists an element $c$ such that $a \cdot b = c$.

#### Associativity:

$(a \cdot b) \cdot c = a \cdot (b \cdot c)$ whenever both sides are defined.
<br>
A group is a special case of a groupoid where every element has an inverse.

### Topological Groupoid:

A topological groupoid is a groupoid equipped with a topology that makes both the composition operation and the inversion operation continuous. This means that the groupoid operations interact nicely with the open sets in the topology.

### Amenable Groupoid:

The term "amenable" in the context of groupoids refers to a property that generalizes the concept of amenability from groups to groupoids. In the context of topological groupoids, a groupoid is amenable if it satisfies a certain version of the Følner condition. The Følner condition, in the context of groupoids, relates to the existence of approximations to the identity element within finite subsets of the groupoid.
<br>
<br>

<p align="center"><b>
The definition of an amenable topological groupoid can be expressed as follows:</b>
</p>
</br>

$$
\begin{align*}
\text{A groupoid } G \text{ is amenable if there exists a sequence of finite subsets } F_n \
\text{such that} \\
\text{for every open set } U \
\text{containing the unit space of } G, \
\text{the following limit holds:} \\
\end{align*}
$$

$$
\lim_{n \to \infty} \frac{|U \cdot F_n - U|}{|F_n|} = 0
$$

In this notation:

- $U \cdot F_n$ represents the set of all elements obtained by composing elements of $U$ with elements of $F_n$.
- $\mathopen|U\mathclose|$ represents the cardinality of the set $X$.

This limit essentially states that the sets $U \cdot F_n$ approximate the set $U$ in a specific way as $n$ approaches infinity.

## References

- [nlab - amenable topological groupoid](https://ncatlab.org/nlab/show/amenable+topological+groupoid)
- [Aidan Sims, Dana P. Williams, _Amenability for Fell bundles over groupoids_ (arXiv:1201.0792)](https://arxiv.org/abs/1201.0792)
- [Johannes Aastrup, Ryszard Nest, Elmar Schrohe, _A Continuous Field of C-algebras and the Tangent Groupoid for Manifolds with Boundary_ (arXiv:math/0507317)](https://arxiv.org/abs/math/0507317)


## Installation

```bash
# Clone the repository
git clone https://github.com/CodeByAidan/Amenable-Topological-Groupoids

# Change directory
cd Amenable-Topological-Groupoids

# Compile the program into the bin directory
javac -d bin src\com\CodeByAidan\topologicalgroupoid\*.java

# Compile Main.java to bin
cd "src" && javac -d ../bin Main.java && cd ..

# Run the program
java -cp bin Main
```

