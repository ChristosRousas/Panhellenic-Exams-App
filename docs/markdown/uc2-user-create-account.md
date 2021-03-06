# ΠΧ2. Εγγραφή Υποψηφίου

**Πρωτεύων Actor**: Υποψήφιος <br>
**Ενδιαφερόμενοι** <br>
**Υποψήφιος**: Θέλει να δημιουργήσει λογαριασμό στην εφαρμογή με τα προσωπικά του στοιχεία, ώστε να προχωρήσει στην καταχώρηση μηχανογραφικού δελτίου.


## Βασική Ροή
1. Ο υποψήφιος επιλέγει την επιλογή εγγραφής.
2. Η εφαρμογή ζητάει από τον υποψήφιο να εισάγει το ονοματεπώνυμο του, τον αριθμό ταυτότητας, την ημερομηνία γέννησης του, το email και το password.
3. Ο υποψήφιος εισάγει τα παραπάνω στοιχεία.
4. Τα στοιχεία εγγραφής του αποθηκεύονται στο σύστημα και δημιουργείται ο λογαριασμός του.

**Εναλλακτικές Ροές**

*3α. Ο χρήστης επιλέγει "Ακύρωση".*
1. Η ΠΧ τερματίζει.

*4α. Ο χρήστης αφήνει έστω και ένα πλαίσιο κενό (δηλαδή όλα τα πλαίσια είναι υποχρεωτικά προς συμπλήρωση) ή εισάγει λανθασμένα στοιχεία, όπως για παράδειγμα ο αριθμός ταυτότητας να μην ξεκινάει με δύο γράμματα ακολουθούμενα από έξι αριθμούς
ή/και η ημερομηνία γέννησης να μην ακολουθεί το σχήμα DD/ΜΜ/ΥΥΥΥ ή/και το email του να μην περιέχει το χαρακτήρα "@" συνεπώς δεν είναι έγκυρο ή/και το μήκος του password να είναι μικρότερο των επτά χαρακτήρων και χωρίς ειδικούς χαρακτήρες.*
1. Το σύστημα εμφανίζει μήνυμα σφάλματος.
2. Η ΠΧ επιστρέφει στο βήμα 2 της βασικής ροής.

## Διαγράμματα 
### Διάγραμμα Δραστηριότητας- Εγγραφή Υποψηφίου

![Διάγραμμα δραστηριότητας - Εγγραφή Υποψηφίου](uml/requirements/activity-create-account1.png)