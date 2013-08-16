module.exports = function (config) {
    config.set({
        basePath: '../',

        frameworks: ['ng-scenario'],

        files: [
            'test/e2e/**/*.js'
        ],

        reporters: ['progress', 'junit'],

        junitReporter: {
            outputFile: 'test-results-e2e.xml',
            suite: 'e2e'
        },

        proxies: {
            '/': 'http://localhost:8000/'
        },

        autoWatch: false,
        singleRun: true,

        browsers: ['Chrome'],

        plugins: [
            'karma-ng-scenario',
            'karma-junit-reporter',
            'karma-chrome-launcher'
        ]

    });
};
