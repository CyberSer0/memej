const path = require('path');
const fs = require('fs');

if (fs.existsSync(`./src/assets/icons/icons.css`)) {
    fs.rmSync(`./src/assets/icons/icons.css`, { force: true });
}

const filelist = [];

fs.readdirSync(`./src/assets/icons/`).forEach(file => {
    filelist.push(file.split('.').slice(0, -1).join('.'));
});

const iconslist = filelist.map(file => `.icon--${file} { mask: url(../icons/${file}.svg); -webkit-mask: url(../icons/${file}.svg) }`);

fs.writeFileSync(`./src/assets/icons/icons.css`, `${iconslist.join(' ')} [class^=icon--],[class*=" icon--"]{width:24px;height:24px;display:block;-webkit-mask-size:cover;mask-size:cover;background-color:#000;-webkit-mask-repeat:no-repeat;mask-repeat:no-repeat;-webkit-mask-position:50% 50%;mask-position:50% 50%;}`);
console.log("Created icons");

