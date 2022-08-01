### Joel Bianchi

# Family Tree Data Structure
* _I am going to Italy this summer for a large family reunion in a small village where my grandmother was born.  I created a spreadsheet with family tree information, but it is too unwieldly in making it visually appealing_


## FamilyMember Object:
### Import Variables to store:
  * `String UID`
  * `String firstName`
  * `String lastName`
  * `Date birthDate`
  * `String birthLocation`
  * `FamilyMember parent1`
  * `FamilyMember parent2`
  * `Date MarriageDate`
  * `FamilyMember spouse`
  * `Date deathDate`
  * `String deathLocation`
  * `String currentLocation`
  * `String notes`
  * `boolean isAncestor`
### Methods
  * toString() method for "top half" of GEDCOM file
  * toStringFam() method for "bottom half" of GEDCOM file
    *  would include UID & FamilyMemberType (spouse or child)

  * _Note: a FamilyMember MUST link to another family member (unless it is designated as `ancestor`)_ 

## FamilyTree Class:
### Import Variables to store:
  * `ArrayList<FamilyMember>`?


## Family Object:
_loop through all family objects and print out at the end_
### Import Variables to store:
  * `int famNum`
  * `String[] spouses`
  * `String[] children`

* There is lots of visualizers for (.ged) GEDCOM file format.  Perhaps it would be best to take in data and output a proper GEDCOM file

## .GED file format features
* Each line preceded with an indentation number
* Each Family Member assigned a specific unique ID
* Varius attributes listed for FamilyMember
* Bottom section lists all the Families found and numbers them
* Families are listed with Spouse members and Children members


## GEDCOM Visualizers:
* https://pewu.github.io/topola-viewer/#/
* http://www.drawmyfamilytree.co.uk/gedcom_viewer.php


## Script Plan
* pull in data from a .csv file
* loop through each line and store as a Java FamilyMember
* Store all FamilyMembers in an ArrayList<FamilyMember>
* Generate header section
* Generate top section - toString() from each FamilyMember
* Generate bottom section
  * Search through FamilyTree to generate list of families
  * Pull data from paste
    
