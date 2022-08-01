# Data Structure Design Challenge
### Collaborators: Seth Adams, Joel Bianchi, Alana Robinson, Théa Williams


# Phonebook Data Structure
* a data structure that represents a phone book
* The phone book will store names and phone numbers of individuals

## Person class
* Each individual will be stored as a Person object:
  * `private String lastName;`
  * `private String firstName;`
  * `private String phoneNumber;`

## Phonebook class
Design a data structure to store a phone book. The entry class should
be named `PhoneBook`, that is, if you were writing a complete, coded
solution your program would contain:



### MAJOR STRUCTURE CONSIDERATIONS:
* Option 1: One Large ArrayList
* Option 2: One Large LinkedList
* Option 3: Duplicate data in One Large AL & 1 Large LL
* Option 4: One 26-sized ArrayList filled up of ArrayList buckets
* ***Option 5: One 26-sized ArrayList filled up of LinkedList buckets***


### Phonebook Data Structure Features
* ***Create an ArrayList of 26 elements*** - sorted ArrayList 
* Each element is pre-determined
* Map the first character to a particular “bucket”


* To `find()` a new word (fast & optimized):
  * Map `charAt(0)` to int and then go to that index
  * Example: `find(“cat”)` in the structure	
    * Use mapping to determine that we should look in index 2 (`'c'` → `2` )
    * Do some type of search inside “bucket” 2 for “cat”
  * If a “bucket” is a sorted ArrayList - do binary search (it will be logarithmic )
  * If a “bucket” is a sorted LinkedList  - ???
* To `add()` a new word (fast & optimized):
  * (inserting into an arraylist in general it will be linear - elements will have to be shifted)
  * Use LinkedList for the buckets (for a fast add)


| FirstLetter|A|B|C|D|E|F|G|...|Z|
|-|-|-|-|-|-|-|-|-|-|
|AL Index|0|1|2|3|4|5|6|...|25|
|Buckets|apple||cat|||fair||...|zoo|
||||cool|||fever||...||
|||||||food||...||
