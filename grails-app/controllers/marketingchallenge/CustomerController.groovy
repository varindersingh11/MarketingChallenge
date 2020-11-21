package marketingchallenge

class CustomerController {

    def index() {
        redirect(action:"addCustomers")
    }

    // Added a sample customer having multiple mobile numbers
    def addCustomers() {
        def cellNumber = new CellNumber(cellNumber:"1234")
        def a = new Customer(customerName: "Varinder")
                .addToCellNumbers(cellNumber)
                .addToCellNumbers(new CellNumber(cellNumber:"6788"))
                .addToCellNumbers(new CellNumber(cellNumber:"8888"))
                .save()
        render(view:'customer')
    }

    // Api to fetch all cell numbers irrespective of customer
    def fetchAllNumbers() {
        try {
            def a = Customer.findAll()
            def cellNumbersList = []
            for (cellNumber in a.cellNumbers) {
                cellNumbersList = cellNumber.cellNumber
            }
            render contentType: "text/json", text: cellNumbersList
        } catch (Exception ex) {
            log.error("Exception raised while fetching all cell numbers " + ex.printStackTrace());
        }
    }

    // Fetch all the cell numbers related to one customer ID
    def getNumbersByCustomerId() {
        try {
            def a = Customer.get(params.id)
            def cellNumbersList = []
            for (cellNumber in a.cellNumbers) {
                cellNumbersList.add(cellNumber.cellNumber)
            }

            render contentType: "text/json", text: cellNumbersList
        } catch(Exception ex) {
            log.error("Exception raised while cell number of a particular customer " + ex.printStackTrace());
        }
    }

    def activateCellNumber() {
        try {
            def cellNumber = params.cellNumber
            def a = Customer.get(params.id)
            def c = a.cellNumbers.find { it.cellNumber == cellNumber }
            c.activated = true
            c.save(flush: true)
            render 'Cell Number activated successfully!!'
        } catch(Exception ex){
            log.error("Exception raised while activating cell number " + ex.printStackTrace())
        }
    }
}
