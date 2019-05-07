const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
module.exports = {
  minimizer: [
    new UglifyJsPlugin({
      test: /\.js(\?.*)?$/i,
      extractComments: false,
      sourceMap: devMode,
      uglifyOptions: {
        warnings: false,
        parse: {},
        compress: { warnings: false, drop_console:  !devMode},
        mangle: true,
        output: { comments: false },
        toplevel: false,
        nameCache: null,
        ie8: false,
        keep_fnames: false,
      },
    }),
  ],
}