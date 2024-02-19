import axios from "axios";
import {base_api} from "../appConfig";


/**
 * API Request Options Template
 * @returns {{method: string, params: {}, url: string}}
 */
export const getOptionsTemplate = () => {
    return {
        method: 'get',
        url: '',
        params: {
        }
    }
};


/**
 * API Error Response Handler
 * @param error
 */
export const handleError = (error) => {
    if (error.response) {
        console.log("Data :" , error.response.data);
        console.log("Status :" + error.response.status);
    } else if (error.request) {
        console.log(error.request);
    } else {
        console.log('Error', error.message);
    }
}


/**
 * Axios Client
 * @type {axios.AxiosInstance}
 */
export const axiosClient = axios.create({
    baseURL: base_api,
});


/**
 * Request Wrapper with default success/error actions
 * @param options
 * @param onSuccess
 * @param onError
 * @returns {Promise<*>}
 */
export const apiRequest = async function (options, onSuccess, onError) {
    const onSuccessHandler = onSuccess ? onSuccess : (response) => {
        console.log('Request Successful - ', response.request.responseURL);
        return response.data;
    }

    const onErrorHandler = onError ? onError : (error) => {
        handleError(error);
        return Promise.reject(error.response || error.message);
    }

    try {
        const response = await axiosClient(options);
        return onSuccessHandler(response);
    } catch (error) {
        return onErrorHandler(error);
    }
}
