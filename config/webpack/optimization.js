const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
module.exports = {
  minimizer: [
    new UglifyJsPlugin({
      test: /\.js(\?.*)?$/i,
      extractComments: false,
      sourceMap: devMode,
      uglifyOptions: {
        parse: {},
        compress: { drop_console:  !devMode},
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