#Google Protocol Buffer


# Serialization
==================
process of persisting the state of an object in file system
using java's own Serialization mechanism.
it is build into Java Language and acts as a quick way to
persist current state of an object.

Has some disadvantages, Some of them would be that it can not 
be used if data is to be shared between different applications 
written in C/C++ or Python etc.
Also, for persisting larger number of objects use an ORM instead.

# JAX - B
============
process of storing state of an object into an xml document
as close to machine level as it is for human level.
very easy to parse an XML document
But, xml has build in disadvantage of being too bulky and
redundant unlike other data storage formats such as json or
yaml.

# Notes
=========
When making a generic class, always make sure to provide type 
bounds in order to make it's misuse harder.