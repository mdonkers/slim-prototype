module.exports = function (config) {
    config.set({
        basePath: '../',

        frameworks: ['jasmine'],

        files: [
            'app/lib/angular/angular.js',
            'app/lib/angular/angular-*.js',
            'app/lib/ingglobal/global.js',
            'test/lib/angular/angular-mocks.js',
            'app/js/*.js',
            'app/js/**/*.js',
            'test/unit/**/*.js',
            'test/mocks/*.js'
        ],

        reporters: ['progress', 'coverage', 'junit'],

        junitReporter: {
            outputFile: 'test-results.xml'
        },

        preprocessors: {
            'app/js/**/*.js': 'coverage'
        },

        autoWatch: true,

        customLaunchers: {
            chrome_custom: {
                base: 'Chrome',
                flags: [
                    '--allow-file-access-from-files'
                ]
            }
        },

        browsers: ['chrome_custom'],

        plugins: [
            'karma-jasmine',
            'karma-junit-reporter',
            'karma-coverage',
            'karma-chrome-launcher'
        ]

    });
};
