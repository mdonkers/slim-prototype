'use strict';

describe('Filter', function () {
    beforeEach(module('pissalotApp'));

    describe('Sec Append filter', function () {
        it('should append the \'sec\' sign to the value', inject(function (secAppendixFilter) {
            expect(secAppendixFilter('123')).toBe('123 sec');
            expect(secAppendixFilter('123')).not.toBe('123sec');
            expect(secAppendixFilter('123,45')).toBe('123,45 sec');
        }));
    });

    describe('Milliseconds to seconds filter', function () {
        it('should convert milliseconds to seconds', inject(function (msToSecFilter) {
            expect(msToSecFilter('123000')).toBe('123');
            expect(msToSecFilter('123600')).toBe('124');
        }));
    });
});
