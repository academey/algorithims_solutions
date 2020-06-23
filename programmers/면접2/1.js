function changeDateFormat(dates) {
    const changedDates = [];
    dates.forEach(date => {
      if (isValidDateFromDate(date)) {
        changedDates.push(getFormattedDateUsingDate(date));
      } else if (isValidDateFromRegex(date)) {
        changedDates.push(getFormattedDateUsingRegex(date));
      }
    });
    return changedDates;
  }
  
  function isValidDateFromDate(date) {
    let isValid = false;
    const validDateFormats = [
      /^\d{4}\/\d{1,2}\/\d{1,2}$/,
      /^\d{1,2}-\d{1,2}-\d{4}$/,
    ];
  
    validDateFormats.some(validDateFormat => {
      if (validDateFormat.test(date)) {
        isValid = true;
      }
      return isValid;
    });
  
    return isValid && !isNaN(Date.parse(date));
  }
  
  function getFormattedDateUsingDate(date) {
    const dateObject = new Date(date);
    const day = pad(dateObject.getDate(), 2);
  
    const month = pad(dateObject.getMonth() + 1, 2);
    const year = pad(dateObject.getFullYear(), 4);
  
    return `${year}${month}${day}`;
  }
  
  function isValidDateFromRegex(date) {
    // First check for the pattern
    const validRegexFormat = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
    if (!validRegexFormat.test(date))
      return false;
  
    // Parse the date parts to integers
    const parts = date.split('/');
    const day = parseInt(parts[0], 10);
    const month = parseInt(parts[1], 10);
    const year = parseInt(parts[2], 10);
  
    // Check the ranges of month and year
    if (year < 1000 || year > 3000 || month === 0 || month > 12)
      return false;
  
    let monthLength = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  
    // Adjust for leap years
    if (year % 400 === 0 || (year % 100 !== 0 && year % 4 === 0))
      monthLength[1] = 29;
  
    // Check the range of the day
    return day > 0 && day <= monthLength[month - 1];
  };
  
  function getFormattedDateUsingRegex(date) {
    const parts = date.split('/');
    const day = pad(parseInt(parts[0], 10), 2);
    const month = pad(parseInt(parts[1], 10), 2);
    const year = pad(parseInt(parts[2], 10), 4);
  
    return `${year}${month}${day}`;
  }
  
  function pad(n, width) {
    const nString = String(n);
    const N = nString.length;
    return N >= width ? nString : new Array(width - N + 1).join('0') + n;
  }
  
  const dates = changeDateFormat(['2010/03/30', '15/12/2016', '11-15-2012', '20130720', '2-1-3']);
  for (let index = 0; index < dates.length; ++index) {
    console.log(dates[index]);
  }
  