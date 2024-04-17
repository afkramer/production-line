import { TypedUseSelectorHook, useSelector } from 'react-redux';
import { RootState } from './reduxStore';

export const useRootSelector: TypedUseSelectorHook<RootState> = useSelector;
