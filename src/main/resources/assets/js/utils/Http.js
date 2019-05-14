const host = 'http://localhost:8080/ws';
const client = {
    get: (params) => $.get(`${host}${params ? params : '/'}`),
    post: (body) => $.post(host, body),
}

export default client;