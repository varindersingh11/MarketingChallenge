package marketingchallenge

class Customer {
    // One to many mapping from customer and cell Numbers
    static hasMany = [cellNumbers: CellNumber]

    String customerName

    static mapping = {
        version false
    }

    static constraints = {
    }
}
