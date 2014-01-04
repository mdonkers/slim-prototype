'use strict';

module.exports = function (config) {
    config.set({
        basePath: '../',

        frameworks: ['jasmine'],

        files: [
            'app/lib/components/angular/angular.js',
            'app/lib/components/angular-mocks/angular-mocks.js',
            'app/lib/components/angular-resource/angular-resource.js',
            'app/js/*.js',
            'app/js/**/*.js',
            'test/mocks/pissalotMockData.js',
            'test/unit/**/*.js'
        ],

        // list of files / patterns to exclude
        exclude: [],

        plugins: [
            'karma-jasmine',
            'karma-junit-reporter',
            'karma-coverage',
            'karma-chrome-launcher',
            'karma-firefox-launcher'
        ],

        reporters: ['progress', 'coverage', 'junit'],

        junitReporter: {
            outputFile: 'test-results.xml'
        },

        preprocessors: {
            'app/js/**/*.js': 'coverage'
        },

        coverageReporter: {
            type: 'html',
            dir: 'coverage'
        },

        // enable / disable colors in the output (reporters and logs)
        colors: true,

        // level of logging
        // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
        logLevel: config.LOG_INFO,

        autoWatch: true,

        // Continuous Integration mode
        // if true, it capture browsers, run tests and exit
        singleRun: false,

        customLaunchers: {
            chromeCustom: {
                base: 'Chrome',
                flags: [
                    '--allow-file-access-from-files'
                ]
            }
        },

        browsers: ['chromeCustom']

    });
};
