export function 
  debounce(fun,delay) {
    let timer = null;
    return function (...argas) {
      if (timer) clearTimeout(timer);
      timer=setTimeout(() => {
      fun.apply(this,argas);
    }, delay);
  }
}