package marketingchallenge

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/customer/customer")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
