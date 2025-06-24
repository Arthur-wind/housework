// 本地存储工具，对 localStorage 进行封装。

// 支持存储/获取字符串和对象，删除、清空本地存储。
// 便于全局数据缓存和读取（如 Token、用户信息等）。

const storage = {
    set(key, value) {
        localStorage.setItem(key, JSON.stringify(value));
    },
    get(key) {
        return localStorage.getItem(key)?localStorage.getItem(key).replace('"','').replace('"',''):"";
    },
    getObj(key) {
        return localStorage.getItem(key)?JSON.parse(localStorage.getItem(key)):null;
    },
    remove(key) {
        localStorage.removeItem(key);
    },
    clear() {
	localStorage.clear();
    }
}
export default storage;
