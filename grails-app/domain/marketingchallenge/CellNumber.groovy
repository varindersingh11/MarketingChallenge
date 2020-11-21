package marketingchallenge

class CellNumber {

    String cellNumber
    boolean activated
    Customer customer
    static belongsTo = [Customer]

    static mapping = {
        version false
    }

    static constraints = {
    }
}
