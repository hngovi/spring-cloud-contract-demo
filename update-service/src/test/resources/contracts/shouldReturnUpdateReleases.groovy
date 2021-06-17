package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'Should return one update release in a list'

    request {
        method GET()
        url '/updates'
    }

    response {
        status OK()
        body '''\
                        [
                            {
                                "id": 1,
                                "description": "IMPORTANT"
                            }
                        ]

'''
    }
}
