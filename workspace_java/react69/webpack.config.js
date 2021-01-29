var path = require('path');

module.exports = {
    context: path.resolve(__dirname, 'src/main/jsx'),/*<= 해당하는 곳에 jsx 파일*/
    entry: {
        main: './MainPage.jsx'
       ,login: './LoginPage.jsx'
    },
    devtool: 'sourcemaps',
    cache: true,
    output: {
        path: __dirname,
        filename: './src/main/webapp/js/react/[name].bundle.js'   /*<= 접두어/[name].접미어    해당하는 곳에 파일이 만들어짐*/
    },
    mode: 'none',
    module: {
        rules: [ {
            test: /\.jsx?$/,
            exclude: /(node_modules)/,
            use: {
                loader: 'babel-loader',
                options: {
                    presets: [ '@babel/preset-env', '@babel/preset-react' ]
                }
            }
        }, {
            test: /\.css$/,
            use: [ 'style-loader', 'css-loader' ]
        } ]
    }
};