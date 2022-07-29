### Joel Bianchi

# Family Tree Data Structure
* _I am going to Italy this summer for a large family reunion in a small village where my grandmother was born.  I created a spreadsheet with information, but it is too unwieldly in making it visually appealing_


## FamilyMember Object:
### Import Variables to store:
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

  * _Note: a FamilyMember MUST link to another family member (unless it is designated as `ancestor`)_ 

## FamilyTree Class:
### Import Variables to store:
  * `ArrayList<FamilyMember>`?
