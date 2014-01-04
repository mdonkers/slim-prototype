'use strict';

describe('Given the Pissalot Couch service', function () {
    var $httpBackend,
        couchGet,
        serviceResult;

    beforeEach(module('pissalotApp'));
    beforeEach(inject(function (_$httpBackend_, pissalotCouchService) {
        $httpBackend = _$httpBackend_;
        couchGet = pissalotCouchService;
    }));

    afterEach(function () {
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });

    describe('When the service is called', function () {
        it('then the information should be returned correctly', function () {
            $httpBackend.expectGET(new RegExp('.*/measurement/latest','i')).respond(pissalotCouchServiceStub.allData, {'Content-type': 'application/json'});

            serviceResult = couchGet.get({ listType: 'latest' });
            $httpBackend.flush();

            expect(serviceResult).toBeDefined();
            expect(serviceResult.items[0].value.sensorId).toEqual('1');
            expect(serviceResult.items[0].value.start).toEqual('1234');
        });
    });
});
