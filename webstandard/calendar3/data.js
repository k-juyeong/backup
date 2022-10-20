let DATA = {

};

Date.prototype.format = function () {
    var yyyy = this.getFullYear();
    var month = (this.getMonth()+1);
    var dd = this.getDate();
    var format = [yyyy, month, dd].join('-');
    return format;
}

Date.prototype.format2 = function () {
    var yyyy = this.getFullYear();
    var month = (this.getMonth()+1);
    var format = [yyyy, month].join('-');
    return format;
}