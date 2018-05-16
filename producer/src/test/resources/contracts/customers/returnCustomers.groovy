package contracts.users

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath('/customers')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body([
                customers: [
                        [
                                firstName: 'Alberto',
                                lastName: 'Resco',
                                emailAddress: 'aresco@pivotal.io'
                        ],
                        [
                                firstName: 'Guinea',
                                lastName: 'Pig',
                                emailAddress: 'guinea@pig.io'
                        ]
                ]
        ])
        headers {
            contentType(applicationJson())
        }

        bodyMatchers {
            jsonPath('$.customers[*].firstName', byRegex(nonBlank()))
            jsonPath('$.customers[*].lastName', byRegex(nonBlank()))
            jsonPath('$.customers[*].emailAddress', byRegex(email()))
        }
    }
}
