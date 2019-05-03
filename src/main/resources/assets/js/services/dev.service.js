import Http from '../utils/Http'


export const getDevs = async (user = 'jeansarlon') => {
        try {
        return await Http.get(`/pessoas/`);
    } catch (error) {
        console.error(error);
    }
}